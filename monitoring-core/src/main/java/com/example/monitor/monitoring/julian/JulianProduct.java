package com.example.monitor.monitoring.julian;

import com.example.monitor.monitoring.global.MonitoringProduct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@ToString(callSuper = true)
public class JulianProduct extends MonitoringProduct {


    private String imageUrl;

    @Setter
    private String category;

    public void setMadeBy(String madeBy) {
        this.madeBy = madeBy;
    }
}
