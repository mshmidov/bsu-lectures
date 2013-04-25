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
        В качестве ответа вам вернется текст для обработки.
    </li>
    <li>
        <h3>Обработка текста</h3>
        <p>Разбейте текст по символу новой строки ("\\n"). Отсортируйте полученные строки в естественном порядке.<br>
        Составьте строку из первых символов каждой строчки отсортированного текста.
        </p>
        <p><b>пример:</b>
            Исходный текст
            <pre>
                In mathematics, the lexicographic or lexicographical
                order, (also known as lexical order, dictionary order,
                alphabetical order or lexicographic(al) product), is a
                generalization of the way the alphabetical order of words
                is based on the alphabetical order of their component letters.
                Fin
            </pre>
        <p>Результирующая строка будет выглядеть так:</p>
            <b>FIagio</b>
    </li>
    <li>
        <h3>Валидация полученной последовательности</h3>
        <p>Необходимо отправить PUT запрос на URL<br>
            http://minsk.exadel.com:7450/{studentName}/sorted-sequence<br>
            и в качестве отправляемого контента должна быть ваша строка (e.g. FIagio)
        </p>
        <p>
            <b>пример:</b> Как делать PUT запрос в java можно узнать в гугле</i>
        </p>
        <p>Если ваш ответ оказался верным, то статус ответа, который вы получите будет 200. Так же в теле полученного ответа <br>
            будет содержаться ключ, который понадобится для следующего шага <br>
    </li>
    <li>
        <h3>Регистрация ключа</h3>
        <p>Необходимо составить  URL вида <br>
            http://minsk.exadel.com:7450/register/{key} (где {key} это полученный ключ на предыдущем этапе)<br>
            и отправить на него запрос.
        </p>
        <p>
            <b>пример:</b> <i>http://minsk.exadel.com:7450/register/c3ZlZ3Vz</i>
        </p>
        <p>Если у ответа будет статус 200 - вы ответили верно. Список верно ответивших можно <br>
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