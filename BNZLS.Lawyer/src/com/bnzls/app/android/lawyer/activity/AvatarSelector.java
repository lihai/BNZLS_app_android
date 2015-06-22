package com.bnzls.app.android.lawyer.activity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import com.bnzls.app.android.lawyer.R;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Toast;

public class AvatarSelector implements OnClickListener {
	private static final int REQUEST_CODE_FROM_CAMERA = 110;
    private static final int REQUEST_CODE_FROM_GALLERY = 111;
    private static final int REQUEST_CODE_CLIP_DONE = 112;
    //private Fragment fragment;
    private File avatarTempCaptureFile;
    private PopupWindow popup;
    private Context _context;


    /**
     * @param activity
     */
    public AvatarSelector(Context activity) {
        //this.fragment = fragment;
    	this._context=activity;
        LayoutInflater inflater = LayoutInflater.from(activity);
        
        View selectView = inflater.inflate(R.layout.im_popup_avatar_select, null);
        popup = new PopupWindow(selectView, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        popup.setBackgroundDrawable(activity.getResources().getDrawable(android.R.color.background_dark));
        popup.setOutsideTouchable(true);
        popup.setAnimationStyle(android.R.style.Animation_Dialog);
        Button btnFromCamera = (Button) selectView.findViewById(R.id.avatar_from_camera);
        btnFromCamera.setOnClickListener(this);

        Button btnFromGallery = (Button) selectView.findViewById(R.id.avatar_from_gallery);
        btnFromGallery.setOnClickListener(this);

    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
        	File camFile;
            switch (requestCode) {
                case REQUEST_CODE_FROM_CAMERA:
                	camFile = new File(Environment.getExternalStorageDirectory(), "/avatar_cap.jpg");
                    if (camFile != null && camFile.exists()) {
                        clipPhoto(Uri.fromFile(camFile));
                    }
                    break;
                case REQUEST_CODE_FROM_GALLERY:
                    clipPhoto(data.getData());
                    break;
                case REQUEST_CODE_CLIP_DONE:
                	camFile = new File(Environment.getExternalStorageDirectory(), "/avatar_cap.jpg");
                    if (camFile != null && camFile.exists()) {
                    	camFile.delete();
                    }
                    saveAvatar(data);
                    break;
                default:
                    break;
            }
        }

    }
    

    private void clipPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 256);
        intent.putExtra("outputY", 256);
        intent.putExtra("return-data", true);
        ((Activity)_context).startActivityForResult(intent, REQUEST_CODE_CLIP_DONE);
    }

    private void saveAvatar(Intent picdata) {
    	/***********code behind************
    	if(Client.getInstance().getProfile() == null){
    		return;
    	}
    	*********************************/
        Bundle extras = picdata.getExtras();
        if (extras != null) {
        	Bitmap photo = extras.getParcelable("data");
        	if (photo != null) {
        		ByteArrayOutputStream output = new ByteArrayOutputStream();
        		photo.compress(CompressFormat.JPEG, 75, output);
        		byte[] bytes = output.toByteArray();
        		BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        		/*****code behind****
				Client client = Client.getInstance();
				client.uploadIcon(bytes);
				client.getProfile().setAvatar(photo);
				*********************/
        		try {
        			output.close();
        		} catch (IOException e) {
        		}
        		
        	}
        }
    }


    public void showAsDropDown(View anchor) {
    	int right = anchor.getRight();
        popup.showAsDropDown(anchor, right+100, (-1) *anchor.getHeight()/2);
    }
    
    public void showAtBottom(View parent) {
    	
        popup.showAtLocation(parent, Gravity.BOTTOM, 0, 0);
    }


    public void setOnDismissListener(OnDismissListener onDismissListener) {
        popup.setOnDismissListener(onDismissListener);
    }

    @Override
    public void onClick(View v) {
        int vid = v.getId();
        if (vid == R.id.avatar_from_camera) {
            avatarTempCaptureFile = new File(Environment.getExternalStorageDirectory(), "/avatar_cap.jpg");
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(avatarTempCaptureFile));
            ((Activity)_context).startActivityForResult(intent, REQUEST_CODE_FROM_CAMERA);
        } else if (vid == R.id.avatar_from_gallery) {
            Intent intent = new Intent(Intent.ACTION_PICK, null);
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            ((Activity)_context).startActivityForResult(intent, REQUEST_CODE_FROM_GALLERY);
        }
        popup.dismiss();
    }
    
    protected void showFailed() {
        Toast toast = Toast.makeText(_context, R.string.save_fail, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }
    
    public boolean isShowing() {
        return popup.isShowing();
    }

    public void dismiss() {
        popup.dismiss();
    }
}
