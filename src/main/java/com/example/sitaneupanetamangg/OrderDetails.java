package com.example.sitaneupanetamangg;


    public class OrderDetails {
        private int orderID;
        private String customerName;
        private Integer mobileNumber;
        private String pizzaSize;
        private Integer toppings;
        private double total;

        public OrderDetails(int orderID, String customerName, int mobileNumber, String pizzaSize, int toppings, double total) {
            this.orderID = orderID;
            this.customerName = customerName;
            this.mobileNumber = mobileNumber;
            this.pizzaSize = pizzaSize;
            this.toppings = toppings;
            this.total = total;
        }

        public int getOrderID() {
            return orderID;
        }

        public void setOrderID(int orderID) {
            this.orderID = orderID;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public int getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(int mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getPizzaSize() {
            return pizzaSize;
        }

        public void setPizzaSize(String pizzaSize) {
            this.pizzaSize = pizzaSize;
        }

        public int getToppings() {
            return toppings;
        }

        public void setToppings(int toppings) {
            this.toppings = toppings;
        }

        public double getTotal() {
            return total;
        }

        public void setTotal(double total) {
            this.total = total;
        }
    }


