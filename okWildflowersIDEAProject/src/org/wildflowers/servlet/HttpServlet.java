package org.wildflowers.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.wildflowers.servlet.DBUtilityOK;

/**
 * Servlet implementation class HttpServlet
 */
@WebServlet("/HttpServlet")
public class HttpServlet extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     // @see javax.servlet.http.HttpServlet#javax.servlet.http.HttpServlet()
     */

    public HttpServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String tab_id = request.getParameter("tab_id");

        // create a report
        if (tab_id.equals("0")) {
            System.out.println("A report is submitted!");
            try {
                createObservation(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // query reports
        else if (tab_id.equals("1")) {
            System.out.println("A query is submitted!");
            try {
                queryObservation(request, response);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void createObservation(HttpServletRequest request, HttpServletResponse
            response) throws SQLException, IOException {
        DBUtilityOK dbutil = new DBUtilityOK();
        String sql;

        // 3. create report
        int report_id = 0;
        String county = request.getParameter("county");
        String genus = request.getParameter("genus");
        String lon = request.getParameter("longitude");
        String lat = request.getParameter("latitude");
        String scientific_name = request.getParameter("scientific_name");
//        String biome = request.getParameter("biome");
//        String date = request.getParameter("date");
        String common_name = request.getParameter("common_name");
        if (county != null) {county = "'" + county + "'";}
        if (genus != null) {genus = "'" + genus + "'";}
        if (scientific_name != null) {scientific_name = "'" + scientific_name + "'";}
        if (common_name != null) {common_name = "'" + common_name + "'";}

        sql = "insert into wildflowers (county, genus, scientific_name, common_name, geom)" +
                " values (" + county + "," + genus + "," + scientific_name
                + "," + common_name + ", ST_GeomFromText('POINT(" + lon + " " + lat + ")', 4326))";
        dbutil.modifyDB(sql);

        // record report_id
        ResultSet res_3 = dbutil.queryDB("select last_value from wildflowers_id_seq");
        res_3.next();
        report_id = res_3.getInt(1);

        System.out.println("Success! Observation created.");

        // response that the observation submission is successful
        JSONObject data = new JSONObject();
        try {
            data.put("status", "success");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.getWriter().write(data.toString());

    }

    private void queryObservation(HttpServletRequest request, HttpServletResponse
            response) throws JSONException, SQLException, IOException {
        //create an empty JSON array to pass into the query helper
        JSONArray list = new JSONArray();

        String genusParam = request.getParameter("genus");
        String commonParam = request.getParameter("common");
        String countyParam = request.getParameter("county");
        String biomeParam = request.getParameter("biome");

        if (genusParam == null && commonParam == null && countyParam == null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers";
            queryObservationHelper(sql,list);
        }

        if (genusParam != null && commonParam == null && countyParam ==null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where genus = " + "'" + genusParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam != null && commonParam != null && countyParam == null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where genus = "
                    + "'" + genusParam + "' and common_name = '" + commonParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam != null && commonParam != null && countyParam != null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where common_name = " + "'" + commonParam + "' " +
                    "and county = '" + countyParam + "' and genus =" + "'" + genusParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam == null && commonParam == null && countyParam != null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where county = " + "'" + countyParam + "'";
            queryObservationHelper(sql,list);
        }
        if (genusParam == null && commonParam != null && countyParam == null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where common_name = " + "'" + commonParam + "'";
            queryObservationHelper(sql,list);
        }
        if (genusParam == null && commonParam != null && countyParam != null && biomeParam == null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where common_name = " + "'" + commonParam + "'" +
                    "and county = '" + countyParam + "'";
            queryObservationHelper(sql,list);
        }
        //add biomeParam
        if (genusParam == null && commonParam == null && countyParam ==null && biomeParam != null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where biome = " + "'" + biomeParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam != null && commonParam == null && countyParam == null && biomeParam != null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where genus = "
                    + "'" + genusParam + "' and biome = '" + biomeParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam != null && commonParam != null && countyParam == null && biomeParam != null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where genus = "
                    + "'" + genusParam + "' and common_name = '" + commonParam + "' and biome = '" + biomeParam + "'";
            queryObservationHelper(sql,list);
        }

        if (genusParam == null && commonParam != null && countyParam == null && biomeParam != null) {
            String sql = "select id, habitat, common_name, biome, recorded_by, county, date, " +
                    "scientific_name, ST_X(geom) as " +
                    "longitude, ST_Y(geom) as latitude from wildflowers where common_name = " + "'"
                    + commonParam + "' and biome = '" + biomeParam + "'";
            queryObservationHelper(sql,list);
        }

        response.getWriter().write(list.toString());
    }

    private void queryObservationHelper(String sql, JSONArray list) throws SQLException {
        DBUtilityOK dbutil = new DBUtilityOK();

        ResultSet res = dbutil.queryDB(sql);
        while (res.next()) {
            // add to response
            HashMap<String, String> m = new HashMap<String,String>();
            m.put("id", res.getString("id"));
            m.put("date", res.getString("date"));
            m.put("county", res.getString("county"));
            m.put("longitude", res.getString("longitude"));
            m.put("latitude", res.getString("latitude"));
            m.put("scientific_name", res.getString("scientific_name"));
            m.put("common_name", res.getString("common_name"));
            m.put("recorded_by", res.getString("recorded_by"));
            m.put("biome", res.getString("biome"));
            m.put("habitat", res.getString("habitat"));
            list.put(m);
        }
    }

    public void main() throws JSONException {
    }
}