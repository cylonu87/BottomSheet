BottomSheet dialogs library for Android with [material design concept][mdguides-url].
Bottom sheets slide up from the bottom of the screen to reveal more content.

<img style="margin-left:0px;" src="/screenshots/demo-gif.gif" width="24%">

<div style="dispaly:flex">
    <img style="margin-left:0px;" src="/screenshots/bs_light_1.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_light_2.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_light_3.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_light_4.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_dark_1.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_dark_2.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_dark_3.png" width="24%">
    <img style="margin-left:0px;" src="/screenshots/bs_dark_4.png" width="24%">
</div>

<div style="dispaly:flex;">
    <img style="margin-left:0px;" src="/screenshots/bs_light_landscape.png" width="49%">
    <img style="margin-left:0px;" src="/screenshots/bs_dark_landscape.png" width="49%">
</div>    

## Demo
[<img src="https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png" alt="" height="100">](https://play.google.com/store/apps/details?id=org.michaelbel.bottomsheetdialog)
[<img src="/screenshots/direct-apk-download.png" alt="" height="100">](https://github.com/michaelbel/BottomSheet/raw/master/app/release/bottomsheet-v1.2.3.apk)

## Usage
```java
BottomSheet.Builder builder = new BottomSheet.Builder(context);
builder
   .setTitle(CharSequence title)
   .setMenu(@MenuRes int menuResId, DialogInterface.OnClickListener listener)
   .setView(@LayoutRes int layoutResId)
   .setContentType(@BottomSheet.Type int type)
   .setDarkTheme(boolean darkTheme)
   .setFullWidth(boolean fullWidth)
   .setCellHeight(int cellHeightDp)
   .setDividers(boolean dividers)
   .setWindowDimming(@Range(from = 0, to = 255) int windowDimming)
   .setTitleMultiline(boolean multiline)
   .setFabBehavior(FloatingActionButton button)
   .setFabBehavior(FloatingActionButton button, @BottomSheet.FabBehavior int fabBehavior)
   .setBackgroundColor(@ColorInt int color)
   .setBackgroundColorRes(@ColorRes int color)
   .setTitleTextColor(@ColorInt int color)
   .setTitleTextColorRes(@ColorRes int color)
   .setItemTextColor(@ColorInt int color)
   .setItemTextColorRes(@ColorRes int color)
   .setIconColor(@ColorInt int color)
   .setIconColorRes(@ColorRes int color)
   .setItemSelector(int selector);
   .setOnShowListener(new DialogInterface.OnShowListener() {
       @Override
       public void onShow(DialogInterface dialog) {
       }
   });
   .setOnDismissListener(new DialogInterface.OnDismissListener() {
       @Override
       public void onDismiss(DialogInterface dialog) {
       }
   });
   .setCallback(new BottomSheetCallback() {
       @Override
       public void onShown() {
       }
       
       @Override
       public void onDismissed() {
       }
   })
   .show();
```

## Wiki
For all information check [BottomSheet Wiki][wiki-url].

## License

    Copyright 2016 Michael Bely

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
