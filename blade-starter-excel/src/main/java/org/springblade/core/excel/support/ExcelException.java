/**
 * Copyright (c) 2018-2099, Chill Zhuang 庄骞 (bladejava@qq.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.core.excel.support;

import java.io.Serial;

/**
 * Excel异常处理类
 *
 * @author Chill
 */
public class ExcelException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 默认构造函数
	 * @param message 异常信息
	 */
	public ExcelException(String message) {
		super(message);
	}
}
