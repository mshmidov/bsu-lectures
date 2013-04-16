<h1>Условие задачи</h1>
<ol>
    <li>
        <h3>Получение текста для обработки</h3>
        <p>Сделайте запрос на URL http://exadel.student-app:8080/{studentName}/text</p>
        <p><b>пример:</b> <i>http://exadel.student-app:8080/martin.fowler/text</i></p>
    </li>
    <li>
        <h3>Обработка текста</h3>
        <p>Найдите 5 самых часто встречаемых слов (используя пробел ("\\s") как разделитель, чтобы разбить<br>
            текст на слова). Если несколько слов имеют одинаковое количество вхождений, то сортировка <br>
            производится по алфавиту
        </p>
        <p><b>пример:</b> gone (13), bean (13), island (9), president (15), abba (9)</p>
        <p>
            <ul>
                <li>president</li>
                <li>bean</li>
                <li>gone</li>
                <li>abba</li>
                <li>island</li>
            </ul>
        </p>
    </li>
    <li>
        <h3>Регистрация верного ответа</h3>
        <p>Необходимо составить  URL вида <br>
            http://exadel.student-app:8080/{studentName}/sequence/{word1}/{word2}/{word3}/{word4}/{word5}<br>
            и отправить на него запрос.
        </p>
        <p>
            <b>пример:</b> <i>http://exadel.student-app:8080/martin.fowler/sequence/president/bean/gone/abba/island</i>
        </p>
        <p>Если у ответа будет статус 200 - вы ответили верно. Так же список верно ответивших можно <br>
        посмотреть на <a style="font: bold;" href="http://exadel.student-app:8080/info">этой</a> странице
    </li>
    <p>Верное решение дает вам 5 баллов. Остальные баллы начисляются за качество кода. Решения скидывать сюда - ???</p>
</ol>