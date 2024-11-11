package com.pluralsight.delilicious;

import java.time.LocalDateTime;
import java.util.List;

public class Orders {
    private List<Items> items;
    private String name;
    private int ordernumber = 1;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Orders(List<Items> items, String name, int ordernumber, LocalDateTime localDateTime) {
        this.items = items;
        this.name = name;
        this.ordernumber = ordernumber ++;
        this.localDateTime = localDateTime;
    }

}
