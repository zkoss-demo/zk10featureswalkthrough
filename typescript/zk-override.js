"use strict";
zk.afterLoad("zul.inp", function () {
    const _xTextbox = zk.augment(zul.inp.Textbox.prototype, {
        getFirstCharacter() {
            var _a;
            return ((_a = this.getValue()) === null || _a === void 0 ? void 0 : _a.substring(0, 1)) || "";
        }
    });
});
