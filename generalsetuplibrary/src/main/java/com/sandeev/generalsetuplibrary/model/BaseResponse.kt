package com.sandeev.generalsetuplibrary.model

data class BaseResponse<D>(
    var message: String?,
    var success: Int?,
    var data: D?,
    var links: LinkResponse?,
    var meta: MetaResponse?
)