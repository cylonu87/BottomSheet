/*
 * Copyright 2016 Michael Bely
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.michaelbel.bottomsheet.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/**
 * Date: 3 MAR 2018
 * Time: 14:04 MSK
 *
 * @author Michael Bel
 */

@SuppressWarnings("all")
public class BottomSheetMenuItem implements MenuItem {

    private static final int CHECKABLE = 0x00000001;
    private static final int CHECKED = 0x00000002;
    private static final int EXCLUSIVE = 0x00000004;
    private static final int HIDDEN = 0x00000008;
    private static final int ENABLED = 0x00000010;

    private final int mId;
    private final int mGroup;
    private final int mOrdering;
    private final int mCategoryOrder;

    private Intent mIntent;
    private Context mContext;

    private CharSequence mTitle;
    private CharSequence mTitleCondensed;

    private char mShortcutNumericChar;
    private char mShortcutAlphabeticChar;

    private Drawable mIconDrawable;

    private int mIconResId = NO_ICON;

    private OnMenuItemClickListener mClickListener;

    private static final int NO_ICON = 0;

    private int mFlags = ENABLED;

    /**
     * Creates a MenuItem
     *
     * @param context       Context of the MenuItem
     * @param group         Group id of the MenuItem
     * @param id            Id of the MenuItem
     * @param categoryOrder Category order of the MenuItem
     * @param ordering      Ordering of the MenuItem
     * @param title         Title of the MenuItem
     */
    public BottomSheetMenuItem(Context context, int group, int id, int categoryOrder, int ordering, CharSequence title) {
        mContext = context;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
    }

    /**
     * Creates a MenuItem
     *
     * @param context Context of the MenuItem
     * @param title   Title of the MenuItem
     * @param icon    Drawable resource of the MenuItem
     */
    public BottomSheetMenuItem(Context context, CharSequence title, @DrawableRes int icon) {
        this(context, 0, 0, 0, 0, title);
        setIcon(icon);
    }

    /**
     * Creates a MenuItem
     *
     * @param context Context of the MenuItem
     * @param title   Title of the MenuItem
     * @param icon    Drawable of the MenuItem
     */
    public BottomSheetMenuItem(Context context, CharSequence title, Drawable icon) {
        this(context, 0, 0, 0, 0, title);
        setIcon(icon);
    }

    /**
     * Creates a MenuItem
     *
     * @param context Context of the MenuItem
     * @param id      Id of the MenuItem
     * @param title   Title of the MenuItem
     * @param icon    Drawable resource of the MenuItem
     */
    public BottomSheetMenuItem(Context context, int id, CharSequence title, @DrawableRes int icon) {
        this(context, 0, id, 0, 0, title);
        setIcon(icon);
    }

    /**
     * Creates a MenuItem
     *
     * @param context Context of the MenuItem
     * @param id      Id of the MenuItem
     * @param title   Title of the MenuItem
     * @param icon    Drawable of the MenuItem
     */
    public BottomSheetMenuItem(Context context, int id, CharSequence title, Drawable icon) {
        this(context, 0, id, 0, 0, title);
        setIcon(icon);
    }

    public char getAlphabeticShortcut() {
        return mShortcutAlphabeticChar;
    }

    public int getGroupId() {
        return mGroup;
    }

    public Drawable getIcon() {
        return mIconDrawable;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public int getItemId() {
        return mId;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return mShortcutNumericChar;
    }

    public int getOrder() {
        return mOrdering;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return mTitle;
    }

    public CharSequence getTitleCondensed() {
        return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (mFlags & CHECKABLE) != 0;
    }

    public boolean isChecked() {
        return (mFlags & CHECKED) != 0;
    }

    public boolean isEnabled() {
        return (mFlags & ENABLED) != 0;
    }

    public boolean isVisible() {
        return (mFlags & HIDDEN) == 0;
    }

    public MenuItem setAlphabeticShortcut(char alphaChar) {
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    public MenuItem setCheckable(boolean checkable) {
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        return this;
    }

    public BottomSheetMenuItem setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        return this;
    }

    public MenuItem setChecked(boolean checked) {
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        return this;
    }

    public MenuItem setEnabled(boolean enabled) {
        mFlags = (mFlags & ~ENABLED) | (enabled ? ENABLED : 0);
        return this;
    }

    public MenuItem setIcon(Drawable icon) {
        mIconDrawable = icon;
        mIconResId = NO_ICON;
        return this;
    }

    public MenuItem setIcon(int iconRes) {
        if (iconRes != NO_ICON) {
            mIconResId = iconRes;
            mIconDrawable = mContext.getResources().getDrawable(iconRes);
        }

        return this;
    }

    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char numericChar) {
        mShortcutNumericChar = numericChar;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener menuItemClickListener) {
        mClickListener = menuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = alphaChar;
        return this;
    }

    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
        return this;
    }

    public MenuItem setTitle(int title) {
        mTitle = mContext.getResources().getString(title);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
        return this;
    }

    public MenuItem setVisible(boolean visible) {
        mFlags = (mFlags & ~HIDDEN) | (visible ? 0 : HIDDEN);
        return this;
    }

    public boolean invoke() {
        if (mClickListener != null && mClickListener.onMenuItemClick(this)) {
            return true;
        }

        if (mIntent != null) {
            mContext.startActivity(mIntent);
            return true;
        }

        return false;
    }

    public void setShowAsAction(int show) {
        // Do nothing. ActionMenuItems always show as action buttons.
    }

    public MenuItem setActionView(View actionView) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    @Override
    public MenuItem setActionView(int resId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ActionProvider getActionProvider() {
        return null;
    }

    @Override
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        setShowAsAction(actionEnum);
        return this;
    }

    @Override
    public boolean expandActionView() {
        return false;
    }

    @Override
    public boolean collapseActionView() {
        return false;
    }

    @Override
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        // No need to save the listener; ActionMenuItem does not support collapsing items.
        return this;
    }
}