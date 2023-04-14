package org.example;


public final class StopException extends RuntimeException {
	/**
	 * 由于Seq并不依赖iterator，所以必须通过异常实现中断。
	 * 为此需要构建一个全局单例的专用异常，同时取消这个异常对调用栈的捕获，
	 * 以减少性能开销（由于是全局单例，不取消也没关系）
	 **/
	public static final StopException INSTANCE = new StopException();

	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

}
