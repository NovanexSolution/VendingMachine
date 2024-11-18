/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.model;

import com.fazecast.jSerialComm.SerialPort;
import javax.swing.SwingUtilities;
import lk.novanex.vendingMachine.component.ProductWindow;
import lk.novanex.vendingMachine.gui.FrontView;

/**
 *
 * @author Madusanka
 */
public class CheckCard {

    public static String userType;

    public static void scanCard() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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

                            if (cardRead.equals("REG")) {
                                userType = "REG";

                                ProductWindow pv = new ProductWindow();
                                FrontView.jPanel3.removeAll();
                                FrontView.jPanel3.add(pv);
                                SwingUtilities.updateComponentTreeUI(FrontView.jPanel3);
                                return;
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
        });

        thread.start();

    }

}
