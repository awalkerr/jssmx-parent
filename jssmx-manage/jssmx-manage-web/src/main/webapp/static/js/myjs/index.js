function cMainFrame() {
    var main = document.getElementById("mainFrame");
    var height = document.documentElement.clientHeight;
    main.style.width = '100%';
    main.style.height = (height - 49) + 'px';
    var page = document.getElementById("pageFrame");
    page.style.height = (height - 41) + 'px';

}

cMainFrame();
window.onresize = function () {
    cMainFrame();
};
loadings();