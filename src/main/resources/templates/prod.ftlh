<!DOCTYPE html>
<html lang="aa">
    <title>${product.title}</title>

    <body>
        <h1>${product.title}</h1>
        <hr>
        <p>Описание: ${product.description}</p>
        <p>Цена: ${product.price}</p>
        <p>Автор: ${product.author}</p>
        <p>Город: ${product.city}</p>
        <form action="/prod/delete/${product.id}" method="post">
            <input type="submit" value="Удалить товар">
        </form>
        <a href="/prod/buy/${product.id}">Продай, зайбал</a>
    </body>
</html>