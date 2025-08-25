package com.priyakdey;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class Main {

    private static final List<String> supportedBusinessLine =
            List.of("electronics", "grocery", "pharmacy", "restaurant");

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Coupon> coupons = new ArrayList<>(code.length);
        for (int i = 0; i < code.length; i++) {
            coupons.add(new Coupon(code[i], businessLine[i], isActive[i]));
        }

        return coupons
                .stream()
                .filter(Coupon::isValid)
                .sorted(Comparator
                        .comparing((Coupon c) -> supportedBusinessLine.indexOf(c.businessLine))
                        .thenComparing(Coupon::code))
                .map(Coupon::code)
                .toList();
    }

    private record Coupon(String code, String businessLine, boolean isActive) {

        public boolean isValid() {
            return isActive && supportedBusinessLine.contains(businessLine) && isValidCode();
        }

        private boolean isValidCode() {
            if (code.isBlank()) return false;

            for (char ch : code.toCharArray()) {
                if (!((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90) || (ch >= 48 && ch <= 57)
                        || (ch == '_'))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        String[] code = {"SAVE20", "", "PHARMA5", "SAVE@20"};
        String[] businessLine = {"restaurant", "grocery", "pharmacy", "restaurant"};
        boolean[] isActive = {true, true, true, true};

        System.out.println(new Main().validateCoupons(code, businessLine, isActive));
    }

}
