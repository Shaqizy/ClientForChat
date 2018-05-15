package ru.specialist;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

                Socket soc = new Socket("localhost",30333);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String string;
                Scanner scan = new Scanner(System.in);
                while (true) {
                    System.out.print("input message > ");
                    string = scan.nextLine();
                    string += '\n';
                    writer.write(string);
                    writer.flush();
                    if("exit\n".equals(string))
                        break;

            String answer = reader.readLine();
            System.out.println("server >" + answer);
        }
    }
}
