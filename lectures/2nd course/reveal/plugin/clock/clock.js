var clock = (function () {

    function Clock() {
        var leftPad = function (value) {
            width = value.toString().length;
            if (width == 1) {
                return "0" + value;
            }
            return value + ""; // always return a string
        };

        var updateTime = function (id) {
            var el = document.getElementById(id);
            var date = new Date();
            var res = leftPad(date.getHours()) + ":" + leftPad(date.getMinutes()) + ":" + leftPad(date.getSeconds());
            el.innerHTML = res;
        };

        this.init = function (id) {
            setInterval(function () {
                updateTime(id)
            }, 1000);
        }
    }

    return new Clock();
})();