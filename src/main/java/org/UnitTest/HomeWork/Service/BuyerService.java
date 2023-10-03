package org.UnitTest.HomeWork.Service;

import org.UnitTest.HomeWork.Domain.Buyer;
import org.UnitTest.HomeWork.Domain.Promotion;

public class BuyerService {
    Promotion promotion = new Promotion();
    public String getUserSale(Buyer buyer) {
        if (buyer.getPrice() < 0) {
            return "Giá không hợp lệ. Giá phải lớn hơn hoặc bằng 0.";
        }
        if(buyer.getTypePeople().equals("người thường")) {
         if (buyer.getPrice() < 15000000) {
                promotion.setAccessory("");
                promotion.setDiscount(0);
                promotion.setWarrantyYear(1);
            } else if (buyer.getPrice() < 25000000) {
                promotion.setAccessory("phụ kiện");
                promotion.setDiscount(0.05);
                promotion.setWarrantyYear(1);
            } else if (buyer.getPrice() >= 25000000) {
                promotion.setAccessory("phụ kiện");
                promotion.setDiscount(0.1);
                promotion.setWarrantyYear(2);
            }
        } else if(buyer.getTypePeople().equals("student"))  {
            if (buyer.getPrice() < 15000000) {
                promotion.setAccessory("phụ kiện");
                promotion.setDiscount(0);
                promotion.setWarrantyYear(2);
            } else if (buyer.getPrice() < 25000000) {
                promotion.setAccessory("phụ kiện");
                promotion.setDiscount(0.1);
                promotion.setWarrantyYear(2);
            } else if (buyer.getPrice() >= 25000000) {
                promotion.setAccessory("phụ kiện");
                promotion.setDiscount(0.15);
                promotion.setWarrantyYear(3);
            }
        }
        String result = "Khách hàng được nhận ";

        if (!promotion.getAccessory().isEmpty()) {
            result += promotion.getAccessory() + ", ";
        }
        result +=  "bảo hành " + promotion.getWarrantyYear() + " năm ";
        if (promotion.getDiscount() > 0) {
            result += "và được giảm giá " +  (promotion.getDiscount() * 100)  + "%.";
        }

        return result;
    }
}
