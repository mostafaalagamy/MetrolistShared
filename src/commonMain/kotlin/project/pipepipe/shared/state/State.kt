package project.pipepipe.shared.state

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import project.pipepipe.shared.infoitem.ChannelInfo
import project.pipepipe.shared.infoitem.CookieInfo
import project.pipepipe.shared.infoitem.Info
import project.pipepipe.shared.infoitem.PlaylistInfo
import project.pipepipe.shared.infoitem.StreamInfo
import project.pipepipe.shared.job.ExtractResult

@Serializable
sealed interface State {
    val step: Int
}

@Serializable
data class PlainState (
    override val step: Int
): State

@Serializable
@SerialName("StreamExtractState")
data class StreamExtractState(
    override val step: Int,
    val streamInfo: StreamInfo
): State

@Serializable
@SerialName("PlaylistExtractState")
data class PlaylistExtractState(
    override val step: Int,
    val playlistInfo: PlaylistInfo
): State

@Serializable
@SerialName("ChannelExtractState")
data class ChannelExtractState(
    override val step: Int,
    val channelInfo: ChannelInfo
): State



@Serializable
data class MetaDataExtractState(
    override val step: Int,
    val metadata: Map<String, String>
): State

@Serializable
data class CookieState(
    override val step: Int,
    val cookieInfo: CookieInfo
): State

@Serializable
data class CachedExtractState(
    override val step: Int,
    val data: ExtractResult<out Info, out Info>
): State

@Serializable
data class PreFetchPayloadState(
    override val step: Int,
    val payload: String
): State