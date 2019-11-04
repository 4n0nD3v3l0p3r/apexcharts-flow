package com.github.appreciated.apexcharts.examples;

import com.github.appreciated.apexcharts.ApexChartsBuilder;
import com.github.appreciated.apexcharts.config.builder.PlotOptionsBuilder;
import com.github.appreciated.apexcharts.config.builder.TitleSubtitleBuilder;
import com.github.appreciated.apexcharts.config.plotoptions.builder.CandlestickBuilder;
import com.github.appreciated.apexcharts.config.plotoptions.candlestick.builder.ColorsBuilder;
import com.github.appreciated.apexcharts.examples.areachart.AreaChartExample;
import com.github.appreciated.apexcharts.examples.areachart.SparkLineExample;
import com.github.appreciated.apexcharts.examples.bar.HorizontalBarChartExample;
import com.github.appreciated.apexcharts.examples.bar.VerticalBarChartExample;
import com.github.appreciated.apexcharts.examples.bubble.BubbleChartExample;
import com.github.appreciated.apexcharts.examples.candlestick.CandleStickChartExample;
import com.github.appreciated.apexcharts.examples.donut.DonutChartExample;
import com.github.appreciated.apexcharts.examples.heatmap.HeatmapChartExample;
import com.github.appreciated.apexcharts.examples.line.LineChartExample;
import com.github.appreciated.apexcharts.examples.mixed.LineAndAreaChartExample;
import com.github.appreciated.apexcharts.examples.mixed.LineAndColumnAndAreaChartExample;
import com.github.appreciated.apexcharts.examples.mixed.LineAndColumnChartExample;
import com.github.appreciated.apexcharts.examples.mixed.LineAndScatterChartExample;
import com.github.appreciated.apexcharts.examples.pie.PieChartExample;
import com.github.appreciated.apexcharts.examples.radar.RadarChartExample;
import com.github.appreciated.apexcharts.examples.radialbar.GradientRadialBarChartExample;
import com.github.appreciated.apexcharts.examples.radialbar.MultiRadialBarChartExample;
import com.github.appreciated.apexcharts.examples.radialbar.RadialBarChartExample;
import com.github.appreciated.apexcharts.examples.scatter.ScatterChartExample;
import com.github.appreciated.apexcharts.examples.timeline.TimeLineChartExample;

import java.util.Arrays;

public class ExampleChartGenerator {
    public static ApexChartsBuilder[] getColoredCharts() {
        return Arrays.stream(getCharts())
                .map(builder ->
                        builder instanceof CandleStickChartExample ?
                                builder.withPlotOptions(PlotOptionsBuilder.get()
                                        .withCandlestick(CandlestickBuilder.get()
                                                .withColors(ColorsBuilder.get()
                                                        .withDownward("#1e88e5")
                                                        .withUpward("#00acc1").build())
                                                .build()
                                        ).build()) :
                                builder.withColors("#1e88e5", "#00acc1", "#5e35b1")
                )
                .toArray(ApexChartsBuilder[]::new);
    }

    public static ApexChartsBuilder[] getCharts() {
        return Arrays.stream(new ApexChartsBuilder[]{
                new PieChartExample(),
                new DonutChartExample(),
                new LineChartExample(),
                new AreaChartExample(),
                new SparkLineExample(),
                new LineAndAreaChartExample(),
                new LineAndColumnChartExample(),
                new LineAndColumnAndAreaChartExample(),
                new LineAndScatterChartExample(),
                new BubbleChartExample(),
                new HorizontalBarChartExample(),
                new TimeLineChartExample(),
                new VerticalBarChartExample(),
                new RadialBarChartExample(),
                new GradientRadialBarChartExample(),
                new MultiRadialBarChartExample(),
                new CandleStickChartExample(),
                new RadarChartExample(),
                new ScatterChartExample(),
                new HeatmapChartExample()
        }).map(builder ->
                builder.withTitle(TitleSubtitleBuilder.get().withText(builder.getClass().getSimpleName()).build())
        ).toArray(ApexChartsBuilder[]::new);
    }
}