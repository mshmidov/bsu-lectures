<head>
    <style>
        div.line {
            background: #000  no-repeat scroll center;
            width:80%;
            height:.05em;
        }

    </style>
</head>
<body>
<h1>Условие задачи</h1>
<ol>
    <li>
        <h3>Получение текста для обработки</h3>
        <p>Сделайте запрос на URL http://minsk.exadel.com:7450/{studentName}/text</p>
        <p><b>пример:</b> <i>http://minsk.exadel.com:7450/martin.fowler/text</i></p>
    </li>
    <li>
        <h3>Обработка текста</h3>
        <p>Найдите 5 самых часто встречаемых слов (используя пробел ("\\s") как разделитель, чтобы разбить<br>
            текст на слова). Если несколько слов имеют одинаковое количество вхождений, то сортировка <br>
            производится по алфавиту
        </p>
        <p><b>пример:</b> gone (13), bean (13), island (9), president (15), abba (9)</p>
        <p>Отсортированные элементы будут выглядеть вот так:
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
            http://minsk.exadel.com:7450/{studentName}/sequence/{word1}/{word2}/{word3}/{word4}/{word5}<br>
            и отправить на него запрос.
        </p>
        <p>
            <b>пример:</b> <i>http://minsk.exadel.com:7450/martin.fowler/sequence/president/bean/gone/abba/island</i>
        </p>
        <p>Если у ответа будет статус 200 - вы ответили верно. Так же список верно ответивших можно <br>
        посмотреть на <a href="http://minsk.exadel.com:7450/info">этой</a> странице
    </li>
    <div class="line"></div>
    <p>Верное решение дает вам 5 баллов. Остальные баллы начисляются за качество кода. Сдавать мне или кидать в расшаренную папку</p>

    <p>Если возникли проблемы с соединением, попробуйте сконфигурить прокси:</p>
    <pre>
System.setProperty("http.proxyHost", "some-proxy-host");
System.setProperty("http.proxyPort", "1111");

Authenticator.setDefault(new Authenticator() {
    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("User", "password".toCharArray());
    }
});
    </pre>
</ol>
</body>