/*
 * Copyright (C) 2017 Orange
 *
 * This software is confidential and proprietary information of Orange.
 * You shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreement you entered into.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * If you are Orange employee you shall use this software in accordance with
 * the Orange Source Charter (http://opensource.itn.ftgroup/index.php/Orange_Source).
 */

package com.orange.dictacloud;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Permission utility functions
 */
public class PermissionUtil {

    public static final Set<String> sAllPermissionsList = new HashSet<>(Arrays.asList(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO));

    public static boolean isAllPermissionsGranted(Context context) {
        for (String permission : sAllPermissionsList) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context, permission)) {
                return false;
            }
        }
        return true;
    }

    public static Set<String> getNotGrantedPermissions(Context context) {
        Set<String> permissionsToAsk = new HashSet<>();
        for (String permission : sAllPermissionsList) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context, permission)) {
                permissionsToAsk.add(permission);
            }
        }
        return permissionsToAsk;
    }

    public static String getNextNotGrantedPermission(Context context) {
        for (String permission : sAllPermissionsList) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context, permission)) {
                return permission;
            }
        }
        return "";
    }

    public static void askPermissions(Activity activity, Set<String> permissionsSet, int permissionsCode) {
        if (permissionsSet.size() > 0) {
            ActivityCompat.requestPermissions(activity,
                    permissionsSet.toArray(new String[permissionsSet.size()]), permissionsCode);
        }
    }

}
