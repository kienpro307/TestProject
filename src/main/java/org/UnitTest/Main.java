package org.UnitTest;
import org.UnitTest.HomeWork.Week4.Domain.Buyer;
import org.UnitTest.HomeWork.Week4.ServiceWeek4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // Đọc danh sách từ tệp đầu vào
            List<Buyer> buyers = readInputFile("C:\\Users\\hp\\Documents\\code\\TestCaseInSchool\\input.txt");

            // Xử lý danh sách và lưu kết quả vào tệp đầu ra
            writeOutputFile("C:\\Users\\hp\\Documents\\code\\TestCaseInSchool\\output.txt", buyers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Buyer> readInputFile(String inputFilePath) throws IOException {
        List<Buyer> buyers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        String line;

        while ((line = reader.readLine()) != null) {
            // Phân tách thông tin từng dòng của danh sách và tạo đối tượng Buyer
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String typePeople = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                buyers.add(new Buyer(typePeople, price));
            }
        }

        reader.close();
        return buyers;
    }

    public static void writeOutputFile(String outputFilePath, List<Buyer> buyers) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        ServiceWeek4 serviceWeek4 = new ServiceWeek4();

        for (Buyer buyer : buyers) {
            // Gọi phương thức và ghi kết quả vào tệp đầu ra
            String result = serviceWeek4.getUserSale(buyer);
            writer.write(result);
            writer.newLine();
        }

        writer.close();
    }
}
