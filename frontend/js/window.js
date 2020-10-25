
const processedIds = [];

function checkedObjects(obj) {
    if ($(obj).is(':checked')) {
        processedIds.push($(obj).attr('data-id'));
    } else if ($(obj).is(':not(:checked)')) {
        const index = processedIds.indexOf($(obj).attr('data-id'));
        if (index > -1) {
            processedIds.splice(index, 1);
        }
    }
}

const removeClass = () => {
    if ($('.nav-item:first').hasClass("active")) {
        $('.nav-item:first').removeClass("active");
    } else if ($('.nav-item:nth-child(2)').hasClass("active")) {
        $('.nav-item:nth-child(2)').removeClass("active");
    } else {
        $('.nav-item:nth-child(3)').removeClass("active");
    }
}