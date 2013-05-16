function isIEBrowser() {
    var isIE = false;

    //Hack: this short statement checks if Internet Explorer is used
    //Conditional compilation is supported only by IE
    /*@cc_on
        isIE = true;
     @*/

    return isIE;
}


if (isIEBrowser()) {
    //Well, we have a problem - this is Internet Explorer

    //Add function trim
    String.prototype.trim = function () {
        return this.replace(/^\s+|\s+$/g, '');
    };
}