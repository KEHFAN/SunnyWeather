package com.sunny.fanke.sunnyweather.gson;

import java.util.List;

public class WeatherBean {

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean {
        /**
         * basic : {"cid":"CN101270101","location":"成都","parent_city":"成都","admin_area":"四川","cnty":"中国","lat":"30.65946198","lon":"104.06573486","tz":"+8.00"}
         * update : {"loc":"2018-08-31 22:45","utc":"2018-08-31 14:45"}
         * status : ok
         * now : {"cloud":"25","cond_code":"101","cond_txt":"多云","fl":"32","hum":"79","pcpn":"0.0","pres":"1006","tmp":"28","vis":"10","wind_deg":"355","wind_dir":"北风","wind_sc":"1","wind_spd":"2"}
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"305","cond_txt_d":"多云","cond_txt_n":"小雨","date":"2018-08-31","hum":"71","mr":"22:29","ms":"10:43","pcpn":"1.0","pop":"55","pres":"1007","sr":"06:40","ss":"19:26","tmp_max":"33","tmp_min":"24","uv_index":"3","vis":"10","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"4"},{"cond_code_d":"300","cond_code_n":"305","cond_txt_d":"阵雨","cond_txt_n":"小雨","date":"2018-09-01","hum":"68","mr":"23:07","ms":"11:42","pcpn":"1.0","pop":"55","pres":"1006","sr":"06:40","ss":"19:25","tmp_max":"34","tmp_min":"24","uv_index":"4","vis":"19","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"6"},{"cond_code_d":"300","cond_code_n":"305","cond_txt_d":"阵雨","cond_txt_n":"小雨","date":"2018-09-02","hum":"76","mr":"23:50","ms":"12:42","pcpn":"2.0","pop":"63","pres":"1005","sr":"06:41","ss":"19:24","tmp_max":"30","tmp_min":"24","uv_index":"4","vis":"18","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"9"},{"cond_code_d":"305","cond_code_n":"104","cond_txt_d":"小雨","cond_txt_n":"阴","date":"2018-09-03","hum":"70","mr":"00:00","ms":"13:44","pcpn":"0.0","pop":"16","pres":"1006","sr":"06:41","ss":"19:23","tmp_max":"31","tmp_min":"24","uv_index":"4","vis":"18","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"5"},{"cond_code_d":"101","cond_code_n":"305","cond_txt_d":"多云","cond_txt_n":"小雨","date":"2018-09-04","hum":"70","mr":"00:37","ms":"14:46","pcpn":"6.0","pop":"80","pres":"1005","sr":"06:42","ss":"19:21","tmp_max":"31","tmp_min":"24","uv_index":"2","vis":"20","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"11"},{"cond_code_d":"305","cond_code_n":"305","cond_txt_d":"小雨","cond_txt_n":"小雨","date":"2018-09-05","hum":"79","mr":"01:31","ms":"15:48","pcpn":"6.0","pop":"68","pres":"1003","sr":"06:43","ss":"19:20","tmp_max":"29","tmp_min":"20","uv_index":"2","vis":"15","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"4"},{"cond_code_d":"305","cond_code_n":"104","cond_txt_d":"小雨","cond_txt_n":"阴","date":"2018-09-06","hum":"79","mr":"02:31","ms":"16:46","pcpn":"4.0","pop":"76","pres":"1007","sr":"06:43","ss":"19:19","tmp_max":"25","tmp_min":"19","uv_index":"5","vis":"15","wind_deg":"-1","wind_dir":"无持续风向","wind_sc":"1-2","wind_spd":"3"}]
         * hourly : [{"cloud":"76","cond_code":"305","cond_txt":"小雨","dew":"24","hum":"95","pop":"51","pres":"1006","time":"2018-09-01 01:00","tmp":"25","wind_deg":"158","wind_dir":"东南风","wind_sc":"5-6","wind_spd":"40"},{"cloud":"83","cond_code":"101","cond_txt":"多云","dew":"22","hum":"95","pop":"58","pres":"1005","time":"2018-09-01 04:00","tmp":"25","wind_deg":"358","wind_dir":"北风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"77","cond_code":"305","cond_txt":"小雨","dew":"24","hum":"90","pop":"40","pres":"1006","time":"2018-09-01 07:00","tmp":"24","wind_deg":"354","wind_dir":"北风","wind_sc":"1-2","wind_spd":"7"},{"cloud":"81","cond_code":"300","cond_txt":"阵雨","dew":"24","hum":"83","pop":"66","pres":"1007","time":"2018-09-01 10:00","tmp":"28","wind_deg":"355","wind_dir":"北风","wind_sc":"1-2","wind_spd":"4"},{"cloud":"76","cond_code":"300","cond_txt":"阵雨","dew":"26","hum":"78","pop":"25","pres":"1005","time":"2018-09-01 13:00","tmp":"32","wind_deg":"31","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"60","cond_code":"300","cond_txt":"阵雨","dew":"24","hum":"76","pop":"20","pres":"1004","time":"2018-09-01 16:00","tmp":"33","wind_deg":"60","wind_dir":"东北风","wind_sc":"1-2","wind_spd":"5"},{"cloud":"58","cond_code":"300","cond_txt":"阵雨","dew":"25","hum":"71","pop":"7","pres":"1006","time":"2018-09-01 19:00","tmp":"29","wind_deg":"166","wind_dir":"东南风","wind_sc":"1-2","wind_spd":"6"},{"cloud":"71","cond_code":"305","cond_txt":"小雨","dew":"25","hum":"83","pop":"7","pres":"1006","time":"2018-09-01 22:00","tmp":"26","wind_deg":"190","wind_dir":"南风","wind_sc":"1-2","wind_spd":"9"}]
         * lifestyle : [{"type":"comf","brf":"较不舒适","txt":"今天夜间天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。"},{"type":"drsg","brf":"炎热","txt":"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。"},{"type":"flu","brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},{"type":"sport","brf":"较不宜","txt":"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意选择避雨防滑并携带雨具。"},{"type":"trav","brf":"较适宜","txt":"有降水，较热，但有微风伴您一路同行，较适宜旅游，您仍可陶醉于大自然的美丽风光中。"},{"type":"uv","brf":"弱","txt":"紫外线强度较弱，建议出门前涂擦SPF在12-15之间、PA+的防晒护肤品。"},{"type":"cw","brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},{"type":"air","brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean {
            /**
             * cid : CN101270101
             * location : 成都
             * parent_city : 成都
             * admin_area : 四川
             * cnty : 中国
             * lat : 30.65946198
             * lon : 104.06573486
             * tz : +8.00
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean {
            /**
             * loc : 2018-08-31 22:45
             * utc : 2018-08-31 14:45
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class NowBean {
            /**
             * cloud : 25
             * cond_code : 101
             * cond_txt : 多云
             * fl : 32
             * hum : 79
             * pcpn : 0.0
             * pres : 1006
             * tmp : 28
             * vis : 10
             * wind_deg : 355
             * wind_dir : 北风
             * wind_sc : 1
             * wind_spd : 2
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean {
            /**
             * cond_code_d : 101
             * cond_code_n : 305
             * cond_txt_d : 多云
             * cond_txt_n : 小雨
             * date : 2018-08-31
             * hum : 71
             * mr : 22:29
             * ms : 10:43
             * pcpn : 1.0
             * pop : 55
             * pres : 1007
             * sr : 06:40
             * ss : 19:26
             * tmp_max : 33
             * tmp_min : 24
             * uv_index : 3
             * vis : 10
             * wind_deg : -1
             * wind_dir : 无持续风向
             * wind_sc : 1-2
             * wind_spd : 4
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean {
            /**
             * cloud : 76
             * cond_code : 305
             * cond_txt : 小雨
             * dew : 24
             * hum : 95
             * pop : 51
             * pres : 1006
             * time : 2018-09-01 01:00
             * tmp : 25
             * wind_deg : 158
             * wind_dir : 东南风
             * wind_sc : 5-6
             * wind_spd : 40
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean {
            /**
             * type : comf
             * brf : 较不舒适
             * txt : 今天夜间天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。
             */

            private String type;
            private String brf;
            private String txt;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }
}
