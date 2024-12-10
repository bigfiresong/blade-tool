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

package org.springblade.core.redis.pubsub;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.redis.cache.BladeRedis;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Redisson pub/sub 发布器
 *
 * @author L.cm
 */
@Slf4j
@RequiredArgsConstructor
public class RedisPubSubPublisher implements InitializingBean, RPubSubPublisher {
	private final BladeRedis bladeRedis;
	private final RedisSerializer<Object> redisSerializer;

	@Override
	public <T> Long publish(String channel, T message) {
		return bladeRedis.publish(channel, message, redisSerializer::serialize);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("RPubSubPublisher init success.");
	}
}
