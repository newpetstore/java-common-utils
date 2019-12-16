/*
 * Java (TM) Pet Store Modernized Edition - 2019
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package common.utils.log.slf4j;

import static java.util.Objects.requireNonNull;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.utils.log.Logging;

/**
 * 
 * @author fabiojose
 *
 */
public class LoggingSlf4j implements Logging {
	
	private final Logger logger;
	
	/**
	 * 
	 * @param type
	 * @throws NullPointerException When type argument is <code>null</code>
	 */
	public LoggingSlf4j(Class<?> type) {
		logger = LoggerFactory.getLogger(requireNonNull(type));
	}

	@Override
	public void info(Supplier<String> message, Object... args) {
		if(logger.isInfoEnabled()) {
			logger.info(message.get(), args);
		}
	}

	@Override
	public void warn(Supplier<String> message, Object... args) {
		if(logger.isWarnEnabled()) {
			logger.warn(message.get(), args);
		}
	}

	@Override
	public void error(Supplier<String> message, Throwable cause, Object... args) {
		if(logger.isErrorEnabled()) {
			logger.error(message.get(), cause);
		}
	}

	@Override
	public void debug(Supplier<String> message, Object... args) {
		if(logger.isDebugEnabled()) {
			logger.debug(message.get(), args);
		}
	}

	@Override
	public void trace(Supplier<String> message, Object... args) {
		if(logger.isTraceEnabled()) {
			logger.trace(message.get(), args);
		}
	}

}
