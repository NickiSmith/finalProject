<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Web Project</title>

  <!-- Custom styles -->
  <link rel="stylesheet" href="css/style.css">

  <!-- jQuery -->
  <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
  <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

  <!-- Bootstrap -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <!-- Google maps API -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB6Xpbv0WISWCAQWBY05c5ln8P6gPf1Bts&libraries=geometry,places">
  </script>


</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <a class="navbar-brand">Oklahoma Wildflower Map</a>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="sidebar col-xs-3">

      <!-- Tab Navis-->
      <ul class="nav nav-tabs">
        <li class="active"><a href="#create_observation" data-toggle="tab">Submit Observation</a></li>
        <li><a href="#query_observation" data-toggle="tab">Query Database</a></li>
      </ul>

      <!-- Tab panes -->
      <div class="tab-content ">
        <!-- Create Report Tab Panel -->
        <div class="tab-pane active" id="create_observation">
          <form id = "create_observation_form">
            <div><label>County:&nbsp</label><input placeholder="County" name="county"></div>
            <div><label>Date:&nbsp</label><input placeholder="Date (YYYY-MM-DD)" name="date"></div>
            <div><label>Scientific_name&nbsp</label><input placeholder="Scientific_name" name="scientific_name"></div>
            <div><label>State:&nbsp</label><input placeholder="State" name="state"></div>
            <div><label>Report Type:</label>
              <select name="report_type">
                <option value="">Choose the report type</option>
                <option value="test">test</option>
                <option value="test2">test2</option>
                <option value="test3">test3</option>
              </select>
            </div>
            <div><label>Address:</label>
              <input id="autocomplete" placeholder="Address" >
            </div>
            <button type="submit" class="btn btn-default" id="report_submit_btn">
              <span class="glyphicon glyphicon-star"></span> Submit
            </button>
          </form>
        </div>

        <!-- Query Report Tab Panel -->
        <div class="tab-pane" id="query_observation">
          <form id = "query_observation_form">
<%--            <div><label>Report Type:</label>--%>
<%--              <select name="report_type">--%>
<%--                <option value="">Choose the report type</option>--%>
<%--                <option value="test">Test</option>--%>
<%--                <option value="test2">Test2</option>--%>
<%--              </select>--%>
<%--            </div>--%>
           <div><label>Start Date:</label>
             <select name="date">
                <option value="">Choose the start date</option>
                <option value="1800">Observations since Jan 1, 1800</option>
                <option value="1900">Observations since Jan 1, 1900</option>
                <option value="2000">Observations since Jan 1, 2000</option>
             </select>
             </div>
            <button type="submit" class="btn btn-default">
              <span class="glyphicon glyphicon-star"></span> Submit the query
            </button>
          </form>
        </div>
      </div>
    </div>

    <div id="map-canvas" class="col-xs-9"></div>

  </div>
</div>

<script src="js/loadformOK.js"></script>
<script src="js/loadmapOK.js"></script>

</body>
</html>