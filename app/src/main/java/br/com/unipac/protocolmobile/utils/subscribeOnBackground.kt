/*package br.com.unipac.protocolmobile.utils

class subscribeOnBackground(function: () -> Unit) {
    Single.fromCallable {
        function()
    }
    .subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .subscribe()
}*/