package com.example.monitor.monitoring.gebnegozi;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class GebenegoziSaleInfo {

    private String brandName;
    private int salesPercent;
    private boolean isColored;
    private String season;
    private String category;
}
