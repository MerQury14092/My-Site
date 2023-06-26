<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Z</title>
</head>
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
</html>