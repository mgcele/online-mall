var gulp = require('gulp');
var less = require('gulp-less');

gulp.task('testLess', function () {
    gulp.src('src/less/login.less')
        .pipe(less())
        .pipe(gulp.dest('css/test'));
});