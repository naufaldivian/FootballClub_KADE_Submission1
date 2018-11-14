package com.example.lenovo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent
        val club = intent.getParcelableExtra<Item>("club")
        DetailClubUI(club).setContentView(this)
    }

    class DetailClubUI(val item: Item) : AnkoComponent<DetailActivity> {
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                imageView {
                    id = R.id.image
                    Glide.with(context).load(item.image).into(this)
                }.lparams(width = dip(100), height = dip(100)) {
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView(item.name) {
                    textSize = 14f
                }.lparams(width = wrapContent) {
                    gravity = Gravity.CENTER_HORIZONTAL
                    topMargin = dip(5)
                }

                textView(item.desc) {
                    id = R.id.desc
                }.lparams(width = wrapContent) {
                    gravity = Gravity.CENTER_HORIZONTAL
                    topMargin = dip(5)
                }
            }
        }
    }
}
