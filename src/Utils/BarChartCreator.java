/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Repositories.DenunciaRepository;
import Service.DenunciaService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
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
    
    public ChartPanel BarChart_Denuncia(int id) { 
        DenunciaRepository dr = new DenunciaRepository();
        DenunciaService ds = new DenunciaService(dr);
        
        Map<String, Integer> hm = ds.denunciasPorDistrito(id);
        
        
      JFreeChart barChart = ChartFactory.createBarChart(
         "Incidencias por Distrito",           
         "",            
         "Cantidad Denuncias",            
         createDataset(hm),          
         PlotOrientation.VERTICAL,           
         true, false, false);
      
      final CategoryPlot plot = barChart.getCategoryPlot();
      Font font3 = new Font("Dialog", Font.BOLD, 10); 
      final CategoryItemRenderer renderer = new CustomRenderer(
            new Paint[] {Color.red, Color.blue, Color.green,
                Color.yellow, Color.orange, Color.cyan,
                Color.magenta}
        );
      renderer.setItemLabelsVisible(true);
      CategoryAxis domainAxis = plot.getDomainAxis();
      domainAxis.setTickLabelFont(font3);
      plot.setRenderer(renderer);
      
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      return chartPanel;
   }
   
   private CategoryDataset createDataset(Map<String, Integer> hm) {
       System.out.println("SE CRE DENUEVO EL DATASET");
      final String cantDenun = "Cantidad denuncias";

    Map<String, String> tiposDenuncia = new HashMap<>();
    tiposDenuncia.put("Robo-Hurto", "Robo-Hurto");
    tiposDenuncia.put("Extorsion", "Extorsion");
    tiposDenuncia.put("Asesinato", "Asesinato");
    tiposDenuncia.put("Violencia Doméstica", "Violencia%nDoméstica");
    tiposDenuncia.put("Feminicidio", "Feminicidio");
    tiposDenuncia.put("Acoso Sexual", "Acoso%nSexual");
    tiposDenuncia.put("Corrupcion", "Corrupcion");

    final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Llenar el dataset con valores del HashMap o con 0 si no están presentes
    tiposDenuncia.forEach((tipo, label) -> {
        int cantidad = hm.getOrDefault(tipo, 0); // Si no está el tipo, coloca 0
        dataset.addValue(cantidad, cantDenun, label);
    });

    return dataset;
   }
    
}