/*
 * Copyright (C) 2017 Moez Bhatti <moez.bhatti@gmail.com>
 *
 * This file is part of Melay SMS.
 *
 * Melay SMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Melay SMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Melay SMS.  If not, see <http://www.gnu.org/licenses/>.
 */
package tech.mattico.melay.manager

import android.content.Context
import android.content.Intent
import com.klinker.android.send_message.BroadcastUtils
import me.leolin.shortcutbadger.ShortcutBadger
//import me.leolin.shortcutbadger.ShortcutBadger
import javax.inject.Inject

class WidgetManagerImpl @Inject constructor(private val context: Context) : WidgetManager {

    override fun updateUnreadCount(count: Int) {
        ShortcutBadger.applyCount(context, count)

        BroadcastUtils.sendExplicitBroadcast(context, Intent(), WidgetManager.ACTION_NOTIFY_DATASET_CHANGED)
    }

}