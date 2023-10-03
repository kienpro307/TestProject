package org.UnitTest;
import org.UnitTest.HomeWork.Domain.Buyer;
import org.UnitTest.HomeWork.Service.BuyerService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

        BuyerService buyerService = new BuyerService();

        for (Buyer buyer : buyers) {
            // Gọi phương thức và ghi kết quả vào tệp đầu ra
            String result = buyerService.getUserSale(buyer);
            writer.write(result);
            writer.newLine();
        }

        writer.close();
    }
}
