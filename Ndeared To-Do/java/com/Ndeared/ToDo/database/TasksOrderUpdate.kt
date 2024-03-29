package com.Ndeared.ToDo.database

import android.content.Context
import android.os.AsyncTask

import com.Ndeared.ToDo.model.ModelTask

/**
 * Moving the tasks update operation in the background thread, in order to get rid of UI lags.
 */
class TasksOrderUpdate(mContext: Context) : AsyncTask<ModelTask, Void, Void>() {
    private val mHelper = DBHelper.getInstance(mContext)

    override fun doInBackground(vararg modelTasks: ModelTask): Void? {
        for (task in modelTasks) {
            mHelper.updateTaskPosition(task)
        }
        return null
    }
}
