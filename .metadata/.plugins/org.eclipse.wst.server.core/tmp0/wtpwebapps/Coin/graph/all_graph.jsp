<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<meta charset="euc-kr" />
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>

<!-- Additional files for the Highslide popup effect -->
<script src="https://www.highcharts.com/media/com_demo/js/highslide-full.min.js"></script>
<script src="https://www.highcharts.com/media/com_demo/js/highslide.config.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="https://www.highcharts.com/media/com_demo/css/highslide.css" />

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
<script>

Highcharts.setOptions({
    lang: {
        thousandsSep: ','
    }
});
var url = ${param.msg};
$.get(url, function(data) {
 Highcharts.chart('container', {
	 colors: ['#2b908f', '#90ee7e', '#f45b5b', '#7798BF', '#aaeeee', '#ff0066', '#eeaaee',
	      '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'],
	   chart: {
	      backgroundColor: {
	         linearGradient: { x1: 0, y1: 0, x2: 1, y2: 1 },
	         stops: [
	            [0, '#242943'],
	            [1, '#242943']
	         ]
	      },
	      style: {
	         fontFamily: '\'Unica One\', sans-serif'
	      },
	      plotBorderColor: '#242943'
	   },

	   data: {
	         csv : data
	     },

     title: {
         text: 'f',
         style: {
             color: '#242943',
             textTransform: 'uppercase',
             fontSize: '20px'
          }
     },

     subtitle: {
         text: 'f',
         style: {
             color: '#242943',
             textTransform: 'uppercase'
          }
     },

     xAxis: {
         tickInterval: 2 * 4 * 3600 * 1000, // 4시간 단위
         tickWidth: 0,
         gridLineColor: '#707073',
         labels: {
            style: {
               color: '#E0E0E3'
            }
         },
         lineColor: '#707073',
         minorGridLineColor: '#505053',
         tickColor: '#707073',
         title: {
            style: {
               color: '#A0A0A3'
            }
         }
     },

     yAxis: [{ // left y axis
    	 gridLineColor: '#707073',
         lineColor: '#707073',
         minorGridLineColor: '#505053',
         tickColor: '#707073',
         tickWidth: 1,
    	 title: {
             text: null
         },
         gridLineWidth: 1,
         labels: {
             format: '{value:.,0f}',
             style: {
                 color: '#FFFFFF'
              }
         },
         showFirstLabel: false
     }, { // right y axis
         linkedTo: 0,
         gridLineWidth: 0,
         opposite: true,
         title: {
             text: null
         },
         labels: {
             format: '{value:.,0f}',
             style: {
                 color: '#FFFFFF'
              }
         },
         showFirstLabel: false
     }],
     
     legend: {
         align: 'left',
         verticalAlign: 'top',
         y: 20,
         floating: true,
         borderWidth: 0,
         itemStyle: {
             color: '#E0E0E3'
          },
          itemHoverStyle: {
             color: '#FFF'
          },
          itemHiddenStyle: {
             color: '#606063'
          }
     },

     tooltip: {
   	      backgroundColor: 'rgba(0, 0, 0, 0.85)',
   	      style: {
   	         color: '#F0F0F0'
   	      }
     },
     plotOptions: {
         series: {
            dataLabels: {
               color: '#B0B0B3'
            },
            marker: {
               lineColor: '#333'
            }
         },
         boxplot: {
            fillColor: '#505053'
         },
         candlestick: {
            lineColor: 'white'
         },
         errorbar: {
            color: 'white'
         }
      },
      drilldown: {
          activeAxisLabelStyle: {
             color: '#F0F0F3'
          },
          activeDataLabelStyle: {
             color: '#F0F0F3'
          }
       },

       navigation: {
          buttonOptions: {
             symbolStroke: '#DDDDDD',
             theme: {
                fill: '#505053'
             }
          }
       },
      credits: {
          style: {
             color: '#666'
          }
       },
       labels: {
          style: {
             color: '#707073'
          }
       },
     series: [{
         name: 'Bithumb',
         lineWidth: 4,
         marker: {
             radius: 4
         }
     }, {
         name: 'Poloneix'
     }]
 });
});
</script>
