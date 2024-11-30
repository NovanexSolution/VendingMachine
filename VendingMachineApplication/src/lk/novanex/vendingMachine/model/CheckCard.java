/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.model;

import com.fazecast.jSerialComm.SerialPort;
import javax.swing.SwingUtilities;
import lk.novanex.vendingMachine.component.ProductWindow;
import lk.novanex.vendingMachine.gui.FrontView;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lk.novanex.vendingMachine.gui.Main;
import lk.novanex.vendingMachine.panel.Status;

/**
 *
 * @author Madusanka
 */
public class CheckCard {

    public boolean cardSearching = true;
    public static String userType;

    private String checkCardReg(String cardNo) {
        String msg = "INVALID";

        try {
            ResultSet result = MySQL.execute("SELECT COUNT(*) AS `num` FROM `card` WHERE `cardNo` = '" + cardNo + "'");

            if (result.next()) {
                int resCount = result.getInt("num");

                if (resCount == 0) {
                    msg = "INVALID"; // no card found
                } else if (resCount == 1) {
                    msg = "VALID"; // valid card
                } else {
                    msg = "INVALID"; //no card found
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg = "INVALID";
        }
        return msg;
    }

    private String checkIsActive(String cardNo) {
        String msg = "Invalid";

        try {
            ResultSet result = MySQL.execute("SELECT COUNT(*) AS `num` FROM `card` INNER JOIN `cardstatus` ON `card`.`cardStatus_id` =  `cardstatus`.`id` WHERE `cardNo` = '" + cardNo + "' AND `cardstatus`.`status` = 'Active'");
            if (result.next()) {
                int resNum = result.getInt("num");

                if (resNum == 1) {
                    msg = "VALID";
                }

                if (resNum == 0) {
                    msg = "Inactive Card";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    public void scanCard() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (cardSearching) {

                    // List available serial ports
                    SerialPort[] ports = SerialPort.getCommPorts();
                    System.out.println("Available Ports:");
                    for (int i = 0; i < ports.length; i++) {
                        System.out.println((i + 1) + ": " + ports[i].getSystemPortName());
                    }

                    // Use COM3 (adjust if needed)
                    SerialPort arduinoPort = ports[0]; // Assuming COM3 is the first port (confirm via output)

                    // Set communication parameters
                    arduinoPort.setComPortParameters(9600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
                    arduinoPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);

                    // Add delay before opening port
                    try {
                        Thread.sleep(1000);  // 2-second delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Try to open the port
                    if (arduinoPort.openPort()) {
                        System.out.println("Port is open.");

                    } else {
                        System.out.println("Failed to open port.");
                        return;
                    }

                    // Read data from the Arduino
                    try {
                        java.util.Scanner scanner = new java.util.Scanner(arduinoPort.getInputStream());
                        while (scanner.hasNextLine()) {
                            try {
                                String cardRead = scanner.nextLine();
                                
//                    serial readings
                                System.out.println(cardRead);
                                String cardCheck = checkCardReg(cardRead);

                                if (cardCheck == "VALID") {
                                    cardSearching = false;
                                    String isActive = checkIsActive(cardRead);
                                    if ((isActive == "VALID")) {

                                    } else {
                                        Status status = new Status("Inactive Card", "Please Renew Your Card!", 0, "");
                                        Main.rootPanel.removeAll();
                                        Main.rootPanel.add(status);
                                        SwingUtilities.updateComponentTreeUI(Main.rootPanel);
                                    }
                                } else {
//                                    call error page for invalid card

                                    cardSearching = false;
                                    Status status = new Status("Invalid Card", "Please Check Your Card Again!", 0, "");
                                    Main.rootPanel.removeAll();
                                    Main.rootPanel.add(status);
                                    SwingUtilities.updateComponentTreeUI(Main.rootPanel);
                                }

                            } catch (Exception e) {
                                System.err.println("Error reading from serial port: " + e.getMessage());
                            }
                        } 
                        scanner.close();
                    } finally {
                        arduinoPort.closePort();
                        System.out.println("Port closed.");
                    }
                }
            }

        });
        Thread.sleep(300);
        thread.start();

    }

}
