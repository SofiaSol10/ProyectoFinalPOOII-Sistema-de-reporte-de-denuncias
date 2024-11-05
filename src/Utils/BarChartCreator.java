/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.awt.Color;
import java.awt.Paint;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author USUARIO
 */
public class BarChartCreator {
    
    class CustomRenderer extends BarRenderer {

        /** The colors. */
        private Paint[] colors;

        /**
         * Creates a new renderer.
         *
         * @param colors  the colors.
         */
        public CustomRenderer(final Paint[] colors) {
            this.colors = colors;
        }

        /**
         * Returns the paint for an item.  Overrides the default behaviour inherited from
         * AbstractSeriesRenderer.
         *
         * @param row  the series.
         * @param column  the category.
         *
         * @return The item color.
         */
        public Paint getItemPaint(final int row, final int column) {
            return this.colors[column % this.colors.length];
        }
    }
    
    public ChartPanel BarChart_Incidencia() {      
      JFreeChart barChart = ChartFactory.createBarChart(
         "Incidencias por Distrito",           
         "",            
         "Cantidad",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, false, false);
      
      final CategoryPlot plot = barChart.getCategoryPlot();
      final CategoryItemRenderer renderer = new CustomRenderer(
            new Paint[] {Color.red, Color.blue, Color.green,
                Color.yellow, Color.orange, Color.cyan,
                Color.magenta}
        );
      renderer.setItemLabelsVisible(true);
      plot.setRenderer(renderer);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      return chartPanel;
   }
   
   private CategoryDataset createDataset( ) {
      final String cant_denun = "Cantidad denuncias";       
      final String robo = "Robo";        
      final String extorsion = "Extorsión";        
      final String asesinatos = "Asesinatos";        
      final String viol_familiar = "Violencia Familiar";
      final String feminicidio = "Feminicidio";
      final String acoso = "Acoso";
      final String corrupcion = "Corrupcion";
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  

      dataset.addValue( 10 , cant_denun , robo);        
      dataset.addValue( 30 , cant_denun , extorsion);        
      dataset.addValue( 50 , cant_denun , asesinatos); 
      dataset.addValue( 60, cant_denun , viol_familiar);
      dataset.addValue( 100 , cant_denun , feminicidio); 
      dataset.addValue( 43 , cant_denun , acoso); 
      dataset.addValue( 75 , cant_denun , corrupcion); 

      return dataset; 
   }
    
}
