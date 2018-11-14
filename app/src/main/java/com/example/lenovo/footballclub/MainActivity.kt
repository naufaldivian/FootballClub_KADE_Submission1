package com.example.lenovo.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.club_description)

        var listItem: MutableList<Item> = mutableListOf()

        for (i in name.indices) {
            listItem.add(Item(name[i], image.getResourceId(i, 0), desc[i]))
        }

        image.recycle()

        val adapter = Adapter(this, listItem) {
            startActivity(intentFor<DetailActivity>("club" to it))
        }
        MainActivityUI(adapter).setContentView(this)
    }
    class MainActivityUI(val mAdapter: Adapter) : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{
                padding = dip(16)
                recyclerView {
                    layoutManager = LinearLayoutManager(ctx)
                    adapter = mAdapter
                }.lparams(width = matchParent, height = wrapContent)
            }

        }
    }
}
