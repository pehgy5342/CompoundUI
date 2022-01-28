package com.example.compoundui.model

object Tag {

    val title = arrayListOf("第1種類型", "第2種類型", "第3種類型")

    val lab1 = arrayListOf(
        Content.Label1("第1項目"),
        Content.Label1("第2項目"),
        Content.Label1("第3項目"),
        Content.Label1("第4項目"),
        Content.Label1("第5項目"),
        Content.Label1("第6項目")
    )

    val lab2 =
        arrayListOf(
            Content.Label2("title1", "A", "APPLE"),
            Content.Label2("title2", "B", "BANANA"),
            Content.Label2("title3", "C", "CAT"),
            Content.Label2("title4", "D", "DUCK"),
            Content.Label2("title5", "E", "EAT"),
            Content.Label2("title6", "F", "FLOWER")
        )
}