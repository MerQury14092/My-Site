<!DOCTYPE html>
<html lang="ru">
    <head>
        <title>Z</title>
    </head>

    <body>
        <h1>Za Avito</h1>
        <h3>Все товары</h3>
        <a href="/signup">Зарегистрироваться</a>
        <a href="/login">Войти</a>
        <#list products as prod>
            <hr>
            <div>
                <p><b>${prod.title}</b> ${prod.price}&#8362;</p>
                <p>${prod.description}</p>
                <p>${prod.author}</p>
                <p>${prod.city}</p>
                <a href="/prod/${prod.id}">Подробнее</a>
            </div>
        </#list>
        <hr>
        <br><br>

        <form action="/prod/create" method="post">
            Название: <label>
                <input type="text" name="title">
            </label>
            Описание: <label>
                <input type="text" name="description">
            </label>
            Цена: <label>
                <input type="number" name="price">
            </label>
            Город: <label>
                <input type="text" name="city">
            </label>
            Автор: <label>
                <input type="text" name="author">
            </label>
            <input type="submit" value="Добавить товар">
        </form>
    </body>
</html>