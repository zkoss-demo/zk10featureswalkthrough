zk.afterLoad("zul.inp",function(){
    const _xTextbox = zk.augment(zul.inp.Textbox.prototype, {
        getFirstCharacter(): string {
            return this.getValue()?.substring(0,1) || "";
        }
    });
});