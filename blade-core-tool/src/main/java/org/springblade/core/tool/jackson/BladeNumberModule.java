/**
 * Copyright (c) 2018-2099, DreamLu 卢春梦 (qq596392912@gmail.com).
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
package org.springblade.core.tool.jackson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 大整数序列化为 String 字符串，避免浏览器丢失精度
 *
 * <p>
 * 前端建议采用：
 * bignumber 库： https://github.com/MikeMcl/bignumber.js
 * decimal.js 库： https://github.com/MikeMcl/decimal.js
 * </p>
 *
 * @author L.cm
 */
public class BladeNumberModule extends SimpleModule {
	public static final BladeNumberModule INSTANCE = new BladeNumberModule();

	public BladeNumberModule() {
		super(BladeNumberModule.class.getName());
		// Long 和 BigInteger 采用定制的逻辑序列化，避免超过js的精度
		this.addSerializer(Long.class, BigNumberSerializer.instance);
		this.addSerializer(Long.TYPE, BigNumberSerializer.instance);
		this.addSerializer(BigInteger.class, BigNumberSerializer.instance);
		// BigDecimal 采用 toString 避免精度丢失，前端采用 decimal.js 来计算。
		this.addSerializer(BigDecimal.class, ToStringSerializer.instance);
	}
}
