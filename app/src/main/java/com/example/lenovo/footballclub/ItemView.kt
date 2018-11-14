package com.example.lenovo.footballclub

import android.content.Context
import android.view.View
import org.jetbrains.anko.*

class ItemView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {

        return linearLayout {
            padding = dip(16)
            imageView {
                id = R.id.image
            }.lparams {
                width = dip(32)
                height = dip(32)
                setMargins(0, 0, dip(16), 0)
            }

            textView {
                textSize = sp(8).toFloat()
                id = R.id.name
            }.lparams {
                width = wrapContent
                height = wrapContent
            }
        }
    }
}