package ru.shop.proviant.config;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.shop.proviant.model.entity.Order;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@RequiredArgsConstructor
public class DataFormatter {

    private final Order order;

    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

}
