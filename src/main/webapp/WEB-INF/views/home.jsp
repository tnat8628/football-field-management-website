<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Football Field Selection</title>
    <!-- Link Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .field-image {
            width: 100%;
            height: auto;
            border-radius: 10px;
            margin-bottom: 20px;
        }
        .choice-card img {
            height: 150px;
            object-fit: cover;
            border-radius: 10px;
        }
        .news-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <!-- Hình sân cỏ -->
        <div class="text-center">
            <img src="<%= request.getContextPath() %>/images/field.jpeg" alt="Football Field" class="field-image">
        </div>

        <!-- Lựa chọn loại sân -->
        <div class="row text-center mt-4">
            <h2>Choose Your Field</h2>
            <%
                String[][] fields = {
                    {"5x5 Field", "field-5x5.jpg", "5x5"},
                    {"7x7 Field", "field-7x7.jpg", "7x7"},
                    {"11x11 Field", "field-11x11.jpg", "11x11"}
                };
                for (String[] field : fields) {
            %>
            <div class="col-md-4 mt-3">
                <div class="card choice-card">
                    <img src="<%= request.getContextPath() %>/images/<%= field[1] %>" alt="<%= field[0] %>" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title"><%= field[0] %></h5>
                        <a href="<%= request.getContextPath() %>/book?field=<%= field[2] %>" class="btn btn-primary">Select</a>
                    </div>
                </div>
            </div>
            <% } %>
        </div>

        <!-- Tin tức bóng đá -->
        <div class="mt-5">
            <h2>Football News</h2>
            <div class="news-list">
                <%
                    String[][] news = {
                        {"Breaking: Team A wins championship", "Team A has secured a victory in the finals with a dramatic penalty shootout.", "1"},
                        {"Player X signs with Team Y", "Star player X officially joins Team Y on a record-breaking transfer deal.", "2"},
                        {"Upcoming: National League fixtures", "The schedule for the upcoming National League has been released.", "3"}
                    };
                    for (String[] newsItem : news) {
                %>
                <div class="news-item">
                    <h5><a href="<%= request.getContextPath() %>/news/<%= newsItem[2] %>"><%= newsItem[0] %></a></h5>
                    <p><%= newsItem[1] %></p>
                </div>
                <% } %>
            </div>
        </div>
    </div>

    <!-- Link Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
