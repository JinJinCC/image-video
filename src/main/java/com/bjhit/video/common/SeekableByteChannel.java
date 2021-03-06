package com.bjhit.video.common;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * 
 * @description
 * @project bjhit-video
 * @author guanxianchun
 * @Create 2015-2-11 下午5:10:14
 * @version 1.0
 */
public interface SeekableByteChannel extends ByteChannel, Channel, Closeable, ReadableByteChannel, WritableByteChannel {
    long position() throws IOException;

    SeekableByteChannel position(long newPosition) throws IOException;

    long size() throws IOException;

    SeekableByteChannel truncate(long size) throws IOException;
}
