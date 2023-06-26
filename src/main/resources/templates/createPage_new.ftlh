<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Create new ad</a>
    </div>
</nav>
<div class="bg-body-tertiary p-5 rounded">
    <form action="/prod/create" method="post">
        Название: <label>
            <input type="text" name="title">
        </label><br><br>
        Описание: <label>
            <input type="text" name="description">
        </label><br><br>
        Цена: <label>
            <input type="number" name="price"> &#8381;
        </label><br><br>
        Город: <label>
            <input type="text" name="city">
        </label><br><br>
        Автор: <label>
            <input type="text" name="author">
        </label><br><br>
        url до preview изображения: <label>
            <input type="text" name="urlToImage">
        </label><br><br>
        <input type="submit" value="Добавить товар">
    </form>
</div>
</body>
</html>