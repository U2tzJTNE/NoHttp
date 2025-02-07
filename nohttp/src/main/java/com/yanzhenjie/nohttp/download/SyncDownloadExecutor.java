/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yanzhenjie.nohttp.download;

import com.yanzhenjie.nohttp.NoHttp;

/**
 *
 * @author Yan Zhenjie
 * @date 2016/10/12
 */
public enum SyncDownloadExecutor {

    INSTANCE,
    AsyncRequestExecutor;

    private Downloader mDownloader;

    SyncDownloadExecutor() {
        mDownloader = new Downloader(NoHttp.getInitializeConfig().getNetworkExecutor());
    }

    /**
     * Start a download.
     *
     * @param what what.
     * @param downloadRequest {@link DownloadRequest}.
     * @param listener accept various download status callback..
     */
    public void execute(int what, DownloadRequest downloadRequest, DownloadListener listener)
      throws Exception {
        mDownloader.download(what, downloadRequest, listener);
    }
}
