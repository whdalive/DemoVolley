package com.example.whdalive.demovolley.Custom;

import java.util.List;

//GsonFormat对应的JavaBean类
public class Weather {

    /**
     * date : 20180404
     * message : Success !
     * status : 200
     * city : 北京
     * count : 1026
     * data : {"shidu":"85%","pm25":14,"pm10":0,"quality":"优","wendu":"2","ganmao":"各类人群可自由活动","yesterday":{"date":"03日星期二","sunrise":"05:58","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:40","aqi":88,"fx":"北风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"},"forecast":[{"date":"04日星期三","sunrise":"05:57","high":"高温 10.0℃","low":"低温 1.0℃","sunset":"18:41","aqi":39,"fx":"东北风","fl":"<3级","type":"雨夹雪","notice":"道路湿滑，步行开车要谨慎"},{"date":"05日星期四","sunrise":"05:55","high":"高温 11.0℃","low":"低温 1.0℃","sunset":"18:42","aqi":62,"fx":"西南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06日星期五","sunrise":"05:53","high":"高温 12.0℃","low":"低温 4.0℃","sunset":"18:43","aqi":56,"fx":"西北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"07日星期六","sunrise":"05:52","high":"高温 14.0℃","low":"低温 3.0℃","sunset":"18:44","aqi":48,"fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08日星期日","sunrise":"05:50","high":"高温 16.0℃","low":"低温 5.0℃","sunset":"18:45","aqi":67,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private DataBean data;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * shidu : 85%
         * pm25 : 14.0
         * pm10 : 0.0
         * quality : 优
         * wendu : 2
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"03日星期二","sunrise":"05:58","high":"高温 13.0℃","low":"低温 4.0℃","sunset":"18:40","aqi":88,"fx":"北风","fl":"3-4级","type":"阴","notice":"不要被阴云遮挡住好心情"}
         * forecast : [{"date":"04日星期三","sunrise":"05:57","high":"高温 10.0℃","low":"低温 1.0℃","sunset":"18:41","aqi":39,"fx":"东北风","fl":"<3级","type":"雨夹雪","notice":"道路湿滑，步行开车要谨慎"},{"date":"05日星期四","sunrise":"05:55","high":"高温 11.0℃","low":"低温 1.0℃","sunset":"18:42","aqi":62,"fx":"西南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"06日星期五","sunrise":"05:53","high":"高温 12.0℃","low":"低温 4.0℃","sunset":"18:43","aqi":56,"fx":"西北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"07日星期六","sunrise":"05:52","high":"高温 14.0℃","low":"低温 3.0℃","sunset":"18:44","aqi":48,"fx":"西北风","fl":"3-4级","type":"晴","notice":"愿你拥有比阳光明媚的心情"},{"date":"08日星期日","sunrise":"05:50","high":"高温 16.0℃","low":"低温 5.0℃","sunset":"18:45","aqi":67,"fx":"南风","fl":"<3级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"}]
         */

        private String shidu;
        private double pm25;
        private double pm10;
        private String quality;
        private String wendu;
        private String ganmao;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public double getPm25() {
            return pm25;
        }

        public void setPm25(double pm25) {
            this.pm25 = pm25;
        }

        public double getPm10() {
            return pm10;
        }

        public void setPm10(double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 03日星期二
             * sunrise : 05:58
             * high : 高温 13.0℃
             * low : 低温 4.0℃
             * sunset : 18:40
             * aqi : 88.0
             * fx : 北风
             * fl : 3-4级
             * type : 阴
             * notice : 不要被阴云遮挡住好心情
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        public static class ForecastBean {
            /**
             * date : 04日星期三
             * sunrise : 05:57
             * high : 高温 10.0℃
             * low : 低温 1.0℃
             * sunset : 18:41
             * aqi : 39.0
             * fx : 东北风
             * fl : <3级
             * type : 雨夹雪
             * notice : 道路湿滑，步行开车要谨慎
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private double aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public double getAqi() {
                return aqi;
            }

            public void setAqi(double aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}
